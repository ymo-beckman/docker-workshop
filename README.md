# docker-workshop
## 说明：
- docker和docker-compose
- 后端spring boot
- 前端react
- 数据库mariadb
- 缓存redis

## 依赖：
- docker desktop (win10或者osx)
- node.js和npm
- maven

## 构建
```
./build.sh
```

## 启动
```
docker-compose up -d
```

## 访问
浏览器访问 <http://localhost:10088>， 输入数字点计算

# Elastic search
## 准备
修改docker设置，分配资源大于4G内存
## 启动
```
cd elastcsearch
docker-compose pull
docker-compose up -d
```

## 关闭
```
docker-compose down
```