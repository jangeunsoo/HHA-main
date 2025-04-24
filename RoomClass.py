#!/usr/bin/env python
# coding: utf-8

# In[13]:


import os
import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.applications import VGG16
from tensorflow.keras.layers import Dense, GlobalAveragePooling2D
from tensorflow.keras.models import Model
from tensorflow.keras.optimizers import Adam

# 데이터셋 디렉토리 경로 (데이터셋 비율 train = 70%, valid = 20%, test = 10%)
train_dir = '/Users/gimmyeongjong/Downloads/Rooms.v1i.folder/train'
valid_dir = '/Users/gimmyeongjong/Downloads/Rooms.v1i.folder/valid'
test_dir = '/Users/gimmyeongjong/Downloads/Rooms.v1i.folder/test'

# 이미지 데이터를 증강하고 전처리하는 ImageDataGenerator 생성
train_datagen = ImageDataGenerator(
    rescale=1./255,           #이미지 픽셀 값을 0과 1 사이로 조정
    rotation_range=20,        #무작위 회전 각도 범위 설정 (0~180 사이의 각도로 무작위 회전)
    width_shift_range=0.2,    #무작위 가로 이동 범위 설정 (전체 너비의 비율로 무작위 이동)
    height_shift_range=0.2,   #무작위 세로 이동 범위 설정 (전체 높이의 비율로 무작위 이동)
    shear_range=0.2,          #무작위 전단 강도 범위 설정
    zoom_range=0.2,           #무작위 확대/축소 범위 설정
    horizontal_flip=True,     #무작위 수평 뒤집기 설정
    fill_mode='nearest'       #이미지를 변형할 때 발생하는 빈 픽셀을 가장 가까운 값으로 채운다
)

valid_datagen = ImageDataGenerator(rescale=1./255)

# 데이터 로드 및 전처리
train_generator = train_datagen.flow_from_directory(
    train_dir,
    target_size=(224, 224),  # 모델에 맞는 입력 크기
    batch_size=32,
    class_mode='categorical'
)

valid_generator = valid_datagen.flow_from_directory(
    valid_dir,
    target_size=(224, 224),
    batch_size=32,
    class_mode='categorical'
)

# 사전 훈련된 VGG16 모델 불러오기
base_model = VGG16(weights='imagenet', include_top=False, input_shape=(224, 224, 3))

# 모델 구축
x = base_model.output
x = GlobalAveragePooling2D()(x)
x = Dense(1024, activation='relu')(x)
predictions = Dense(5, activation='softmax')(x)  # 분류할 클래스 수에 맞추어 변경

model = Model(inputs=base_model.input, outputs=predictions)

# VGG16 모델의 가중치 고정
for layer in base_model.layers:
    layer.trainable = False

# 모델 훈련 설정
model.compile(optimizer=Adam(learning_rate=0.0001), 
              loss='categorical_crossentropy', 
              metrics=['accuracy'])

# 모델 훈련
history = model.fit(
    train_generator,
    steps_per_epoch=len(train_generator),
    epochs=20,  # 필요에 따라 조정
    validation_data=valid_generator,
    validation_steps=len(valid_generator)
)

# 정확도 및 손실 그래프 시각화
plt.plot(history.history['accuracy'], label='accuracy')
plt.plot(history.history['val_accuracy'], label='val_accuracy')
plt.xlabel('Epoch')
plt.ylabel('Accuracy')
plt.legend()
plt.show()

# 테스트 데이터 평가
test_datagen = ImageDataGenerator(rescale=1./255)
test_generator = test_datagen.flow_from_directory(
    test_dir,
    target_size=(224, 224),
    batch_size=1,
    class_mode='categorical',
    shuffle=False
)

loss, accuracy = model.evaluate(test_generator)
print("Test Accuracy:", accuracy)

# 테스트 이미지 분류 예측
class_names = list(train_generator.class_indices.keys())

for i in range(len(test_generator)):
    test_images, test_labels = test_generator[i]
    predictions = model.predict(test_images)
    predicted_class = class_names[np.argmax(predictions)]
    
    print("Predicted class for {}: {}".format(test_generator.filenames[i], predicted_class))


# In[ ]:




