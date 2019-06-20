# 地铁调度助手
<div align=center><img src="https://upload.wikimedia.org/wikipedia/en/3/31/Shanghai_Metro_logo.svg" width="20%"></div>

## 项目说明

本数据库项目为基于交通卡刷卡数据的可视化地铁调度助手，数据来源主要为上海市交通卡地铁站刷卡数据，通过数据库技术与前后端技术构建一个为地铁管理人员开放权限的地铁线路、地铁站点、地铁班次以及人流量信息查询、更改及可视化的web网页端地铁调度助手模拟，为进一步改良地铁运营规划进行初步模拟。

## 项目目录简介

-   SubwayFrontEnd

    为本项目的前端项目

-   SubwayServer

    为本项目的后端项目

    -   src/main/java/org/haven存储的为Java代码
    -   src/main/resources中包含配置文件,SQL,以及读取数据文件的Python代码

## 开发环境

-   Windows10
-   后端IDE采用IntelliJ IDEA 2019.1 x64
-   前端通过VS code文本编辑器进行编写
-   后端数据库采用MySQL 8.0

## 项目运行

1.  将本项目clone到本地

2.  运行前端项目

    1.  进入SubwayFrontEnd

    2.  输入命令

        ```bash
        npm install 
        ```

    3.  输入命令

        ```bash
        npm run dev
        ```

3.  运行后端项目

    1.  进入**SubwayServer/src/main/resources**，找到**transport.sql**文件，在数据库中执行所有建表和插入语句
    2.  在IntelliJ IDEA中安装好Maven项目的依赖包
    3.  在IntelliJ IDEA中运行

## 技术栈

### 后端技术栈

-   SprintBoot
-   SpringSecurity
-   MyBatis
-   MySQL 8.0

<div align=center><img src="https://i2.wp.com/www.thecuriousdev.org/wp-content/uploads/2017/12/spring-boot-logo.png?w=600&ssl=1" width="20%"></div>

<div align=center><img src="https://upload.wikimedia.org/wikipedia/zh/6/62/MySQL.svg" width="20%"></div>

### 前端技术栈

-   Vue.js
-   axios
-   ElementUI
-   vue-echarts
-   vue-router

  <div align=center><img src="https://vuejs.org/images/logo.png" width="20%"></div>





