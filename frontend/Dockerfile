FROM nginx:alpine


COPY ./conf/nginx.conf /etc/nginx/conf.d/default.conf
COPY ./build  /usr/share/nginx/html/dist

EXPOSE 80