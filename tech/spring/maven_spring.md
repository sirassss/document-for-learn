- `spring-boot-starter-parent`: chứa các thông số phụ thuộc chung tương thích với nhau ví dụ như version, plugins, ...
  và việc kế thừa từ nó ta sẽ quản lý project dễ dàng hơn
- `spring-cloud-zookeeper`: là sử dụng zookeeper làm kho lưu trữ thông tin các service, cung cấp bộ cân bằng tải, quản lý cấu hình
- `Spring Cloud CLI`: là công cụ tải về máy, không phải thư viện dùng để quản lý các cloud service
- `spring-cloud-function`: hỗ trợ viết các function và đăng ký function đó là 1 rest-api với endpoint là tên của method đó luôn
- `spring-boot-starter-batch`: định nghĩa các công việc và cho nó chạy giống như schedule nhưng nó là xử lý đồng thời
- `spring-cloud-starter-bootstrap`: thêm để có thể sử dụng được file bootstrap.yml để cấu hình
- `spring.application.name`:thường được sử dụng để định danh ứng dụng trong các trường hợp như ghi log hoặc cấu hình chung