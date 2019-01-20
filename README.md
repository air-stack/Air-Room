# Air Room

> 模拟物联网设备通过Socket发送TCP数据包，建立调度线程池，添加虚拟传感器对象，模拟大气环境检测系统，通过Socket推送Tcp模拟数据包到服务器。

## 技术栈

> Swing + ThreadPool + Socket

## TCP服务器

Air-Room :[https://github.com/kevinten10/Air-Room]

## 协议编码

Air-Protocol :[https://github.com/kevinten10/Air-Protocol]

需导入Protocol的本地jar包 (项目目录下的Air-Protocol.jar)

## 运行

启动Main方法，点击"添加传感器"生成虚拟传感器(最大容量为8个)，点击"运行"，则每隔3S每个传感器会通过HTTP发送一个虚拟监测数据到SERVER。

## 异常情况

十六进制协议字符串被编码成byte[]，再SERVER进行解码时，可能由于编解码协议冲突，导致解码后为乱码。

### 快速部署

已将打包好的jar包放在目录下，将Air_Room_jar拷贝到服务器文件下即可，进入目录，输入

    java -jar Air-Room.jar
    
即可运行服务

后台运行：nohup java -jar Air-Room.jar > /usr/local/air/room.out  &

### docker部署

    docker run -d --network host -v /usr/local/air/Air_Room_jar/Air-Room.jar:/usr/local/air/Air_Room_jar/Air-Room.jar --name air-back java:8u111 java -jar /usr/local/air/Air_Room_jar/Air-Room.jar
    
解析    
   
    --network host ：本身与宿主机共用了网络，容器中暴露端口等同于宿主机暴露端口。
    
    -d 表示在后台启动
        
    -v /usr/local/air/Air_Room_jar/Air-Room.jar:/usr/local/air/Air_Room_jar/Air-Room.jar 表示将宿主主机的jar文件，映射到容器中（分号前为宿主主机的路径，分号后为容器中的路径）
    
    --name air-back 表示为该容器取一个全局唯一的名称，这里我取的名称为air-back
    
    java:8u111 表示镜像文件的名称和tag
    
    java -jar /usr/local/air/Air_Room_jar/Air-Room.jar 表示运行jar包，注意：这里的jar包为容器中的位置，是通过前面的-v属性映射的
    
