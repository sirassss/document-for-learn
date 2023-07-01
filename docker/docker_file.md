

+ `FROM`: chỉ định image gốc, base để xây dựng môi trường
+ `EXPOSE`: là chỉ đinh port ánh xạ của container ra ngoài, không có tác dụng mở port
+ `RUN`: dùng để run các command cmd khi build image, dùng để tạo các package, container
+ `CMD`: dùng để run các command cmd để thực thi(`run`) container
+ `ENTRYPOINT`: giống `CMD` và hơn ở chỗ là chạy được file `script .sh`
+ `ENV`: thiết lập biến môi trường
+ `WORKDIR`: chỉ thị thư mục làm việc chính
+ `VOLUME`: mount dữ liệu từ trong container ra ngoài máy host