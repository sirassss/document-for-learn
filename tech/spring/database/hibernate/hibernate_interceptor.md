### CONCEPT
- Cung cấp các phương thức có thể được gọi ở các giai đoạn khác nhau, để thực hiện một số nhiệm vụ được yêu cầu.
- Đăng ký dưới dạng call back, liên kết giữa session và application

### IMPLEMENT

- Implement org.hibernate.Interceptor interface.
- extend org.hibernate.EmptyInterceptor class.
- Nên làm theo hướng extend EmptyInterceptor 
- Một Interceptor có thể được sử dụng ở: Session hoặc SessionFactory scope.

### Hibernate StatementInspector

- có khả năng sửa câu sql trước khi save