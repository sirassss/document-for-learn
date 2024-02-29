
## Vòng đời của bean: 
- Khi IoC Container (ApplicationContext) tìm thấy một Bean cần quản lý, nó sẽ khởi tạo bằng Constructor
- inject dependencies vào Bean bằng Setter, và thực hiện các quá trình cài đặt khác vào Bean như setBeanName, setBeanClassLoader, v.v..
- Hàm đánh dấu @PostConstruct được gọi
- Tiền xử lý sau khi @PostConstruct được gọi.
- Bean sẵn sàng để hoạt động
- Nếu IoC Container không quản lý bean nữa hoặc bị shutdown nó sẽ gọi hàm @PreDestroy trong Bean
- Xóa Bean.

## scope của bean (@Scope)

- Đây là phạm vi Bean được sinh ra và bị phá hủy dưới sự quản lí của Spring Container. Khi Bean sinh ra có các phạm vi
  được sử dụng và các tùy chỉnh của nó:
+ `Singleton`: Đây sẽ là scope mặc định của 1 bean khi được sinh ra. nó có nghĩa: “bean chỉ tạo 1 lần và sử dụng trong
  container. Chỉ duy nhất một bean tồn tại trong container”.
  → Có nghĩa là tại 1 thời điểm Container chỉ load một Bean nhất định.
+ `Prototype`: ngược lại với Singleton, mỗi lần yêu cầu bean thì sẽ là 1 instance hoàn toàn mới.
+ `Request`: Bean được sinh ra thông qua các HTTP Request của người dùng. Chỉ được dụng trong các ứng dụng Web.
+ `Session`: Bean được sinh ra thông qua các HTTP Session.
+ `Global-session` : Bean được sinh ra thông qua các request http (yêu cầu) từ người dùng. Chỉ được dùng trong các ứng dụng web.