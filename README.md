# Air Room

> 模拟物联网设备通过Socket发送TCP数据包，建立调度线程池，添加虚拟传感器对象，模拟大气环境检测系统，通过Socket推送Tcp模拟数据包到服务器。

## 技术栈

> Swing + Observer + ThreadPool + Socket

## TCP服务器

Air-Server :[https://github.com/kevinten10/Air-Server]

## 协议

编码规则遵守Air-Server中的通信协议，采用十六进制编码，包含相关数据信息

## 运行

启动Main方法，点击"添加传感器"生成虚拟传感器(最大容量为8个)，点击"运行"，则每隔3S每个传感器会通过HTTP发送一个虚拟监测数据到SERVER。

