
## CONCEPT

- mỗi 1 server vật lý là 1 node trong docker swarm
- docker swarm sẽ quản lý các service
- mỗi service là 1 đại diện cho 1 container, mỗi 1 container có thể có nhiều bản sao
- docker swarm dùng network overlay giao tiếp với nhau qua DNS là service name

## COMMAND

#### NODE

````
docker swarm init --advertise-addr 192.168.99.100
````

- lệnh tạo 1 node với ip được chỉ định

````
docker swarm join --token <token> <ip-address>:<port>
````

- lệnh join 1 node vào swarm manage với token và ip:port chỉ định


````
docker swarm leave
````

- thoát 1 node khỏi swarm manager, thêm `--force` thì sẽ tắt hẳn swarm manager



#### SERVICE

````
docker stack deploy -c docker-compose.yml <service-name> // 
````

- chạy các service trong file docker compose

````
docker service create --name <service-name> <image-name>
````

- chạy riêng lẻ các service

````
docker service scale <service-name>=<replica-count>
````

- tạo số lương replica cho 1 service

