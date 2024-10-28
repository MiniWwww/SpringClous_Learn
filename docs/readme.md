## 商城后台管理系统

## 项目介绍
基于springcloud+springboot+vue3 搭建的商城后台管理系统  

## 安装使用
``` bash
 #后端构建
 1.单机启动nacos服务注册中心 (需要下载nacos,如果你的电脑没有可以在项目里的nacos文件里启动 cd到nacos的bin 目录 cmd打开 （win系统）./startup.cmd  -m standalone 即可) 
 2.在本地创建 "cloud_sc" 数据库 然后运行数据库脚本
 3.本地配置java运行环境(1.8版本)
 4.idea最好用idea提供的maven
 #后端启动
  首先启动gateway包下的gatewayAppliction的main程序
  然后相继启动service下的服务
 #前端运行
  cd到 web-user（前台） 和 web-admin(后台) 包下 先下载依赖 命令行输入 npm i 前台和后台都需要执行这个命令一次
  node 版本 我的是16.18.1
  运行 npm run dev 
```


 