#!/usr/bin/env python
# coding: utf-8

# In[25]:


import os
import cv2
import numpy as np
import matplotlib.pyplot as plt

# 주요 색상 추출 함수 정의
def extract_main_colors(image):
    pixels = image.reshape((-1, 3))
    pixels = np.float32(pixels)

    criteria = (cv2.TERM_CRITERIA_EPS + cv2.TERM_CRITERIA_MAX_ITER, 200, 0.2)
    k = 5  # 주요 색상 개수 설정
    _, labels, centers = cv2.kmeans(pixels, k, None, criteria, 10, cv2.KMEANS_RANDOM_CENTERS)

    # 각 클러스터의 색상 중심 계산
    unique, counts = np.unique(labels, return_counts=True)
    color_ratios = counts / np.sum(counts)

    # 주요 색상을 내림차순으로 정렬
    sorted_indices = np.argsort(color_ratios)[::-1]
    sorted_centers = centers[sorted_indices]
    sorted_ratios = color_ratios[sorted_indices]

    return sorted_centers.astype(np.uint8), sorted_ratios

# 주요 색상 시각화
def visualize_color_palette(colors, ratios):
    fig, ax = plt.subplots()
    normalized_colors = [(color[0] / 255, color[1] / 255, color[2] / 255) for color in colors]
    ax.pie(ratios, colors=normalized_colors, autopct='%1.1f%%')  # 각 색상의 비율을 pie chart로 나타냄
    ax.axis('equal')  # 원형을 유지하여 원이 동그랗게 표시되도록 함
    plt.show()

# 클래스 별 대표 색상 정의
class_colors = {
    "모던": [(255, 255, 255), (0, 0, 0), (128, 128, 128)],  # 흰색, 검은색, 회색
    "빈티지": [(102, 51, 0), (0, 0, 0)],  # 짙은 갈색, 검은색
    "클래식": [(102, 51, 0), (0, 0, 0), (245, 245, 220)],  # 짙은 갈색, 검은색, 베이지색
    "프로방스": [(255, 255, 255), (245, 245, 220)]  # 흰색, 베이지색
}

# 색상 간 거리 계산 함수
def color_distance(color1, color2):
    return np.sqrt((color1[0] - color2[0]) ** 2 + (color1[1] - color2[1]) ** 2 + (color1[2] - color2[2]) ** 2)

# 이미지를 클래스로 분류하는 함수
def classify_image(colors, ratios):
    min_distance = float('inf')
    classified_class = None
    for class_name, class_color in class_colors.items():
        # 대표 색상 비율이 70%를 넘는 경우에만 분류
        if sum(ratios[:len(class_color)]) > 0.7:
            distance = sum([min(color_distance(color, class_color[i]) for color in colors) for i in range(len(class_color))])
            if distance < min_distance:
                min_distance = distance
                classified_class = class_name
    return classified_class

# 디렉토리 내 모든 이미지 파일 경로 가져오기
def get_image_paths(directory):
    image_paths = []
    for filename in os.listdir(directory):
        if filename.endswith(".jpg") or filename.endswith(".jpeg") or filename.endswith(".png"):
            image_paths.append(os.path.join(directory, filename))
    return image_paths

# 디렉토리 경로 설정
directory = "/Users/gimmyeongjong/Downloads/DS"  # 디렉토리 경로를 변경하세요.

# 디렉토리 내 이미지 파일 경로 가져오기
image_paths = get_image_paths(directory)

# 각 이미지에서 주요 색상 추출 및 시각화 및 클래스 분류
for i, image_path in enumerate(image_paths, start=1):
    print(f"이미지 {i}: {image_path}")

    # 이미지 읽기
    image = cv2.imread(image_path)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

    # 주요 색상 추출
    centers, ratios = extract_main_colors(image)
    colors = [tuple(center) for center in centers]

    # 주요 색상 시각화
    visualize_color_palette(colors, ratios)

    # 이미지 클래스 분류
    image_class = classify_image(colors, ratios)
    if image_class:
        print(f"분류된 분위기: {image_class}")
    else:
        print("분류할 수 없는 분위기입니다.")


# In[ ]:





# In[ ]:




