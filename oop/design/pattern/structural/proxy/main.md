## CONCEPT

- Thuộc nhóm Structural
- Điều khiển gián tiếp việc truy xuất 1 đối tượng qua 1 đối tượng khác
- Wrap 1 object và cung cấp các phương thức truy cập đến nó

## PURPOSE

- Giải quyết vấn đề performance, validate,...

## ARCHITECTURE

![architecture](ar.png)

- `Service interface`: giao diện của đối tượng muốn sử dụng
- `Service`: đối tượng cần sử dụng được triển khai từ service interface
- `Proxy`: Duy trì 1 tham chiếu đến service
  + `Remote proxies` chịu trách nhiệm mã hóa một yêu cầu và các đối số của nó và gửi yêu cầu được mã hóa đến Service trong một không gian địa chỉ khác.
  + `Virtual proxies` có thể cache thông tin bổ xung về Service để trì hoãn việc truy cập nó.
  + `Protection proxies` kiểm tra xem có quyền truy cập cần thiết để thực hiện yêu cầu hay không.

- Đối tượng proxy có thể hoạt động như trung gian giữa máy khách và đối tượng đích.
- Đối tượng proxy có cùng giao diện với đối tượng đích.

## BENEFIT

### PROS

- Tuân thủ OCP: có thể thêm mới 1 proxy mà không cần thay đổi service hay client
- cải thiện performance thông qua lazy loading
- Bảo vệ object từ thế giới bên ngoài
- Giảm chí phí cho nhiều truy cập vào 1 đối tượng có chi phí khởi tạo lớn

### CONS

- Phức tạp
- Response từ service có thể bị hoãn

## USE WHEN

- Có những tình huống mà khách hàng không hoặc không thể tham chiếu trực tiếp đến một Đối tượng, nhưng vẫn muốn tương
  tác với đối tượng.

- Muốn kiểm soát người truy cập, log truy cập, hoặc cache