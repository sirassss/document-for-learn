## CONCEPT

- Thuộc nhóm Structural
- Lồng các chức năng với nhau chỉ với 1 đối tượng
- Lớp Decorator mới để bọc lấy một đối tượng hiện có và thêm hoặc bớt chức năng của đối tượng đó
- Mở rộng hoặc thay đổi hành vi của một đối tượng mà không làm thay đổi hành vi của các đối tượng khác trong hệ thống
- Tạo ra 1 stack các hành vi, chức năng cho 1 đối tượng

## PURPOSE

- Khi 1 service triển cần phải triển khai trên nhiều mô hình khác nhau 
> VD: thông báo bằng facebook, zalo, gmail,...

- Ta sẽ cần tạo 1 lớp cơ sở và sau đó sẽ từ lớp cơ sở này để phát triển các mô hình khác

## ARCHITECTURE

- `Component`: là một interface quy định các method chung cần phải có cho tất cả các thành phần tham gia vào mẫu này.
- `Concrete Component`: là lớp hiện thực (implements) các phương thức của Component.
- `Decorator`: là một abstract class dùng để duy trì một tham chiếu của đối tượng Component và đồng thời cài đặt các
  phương thức của Component interface.
- `Concrete Decorator`: là lớp hiện thực (implements) các phương thức của Decorator, nó cài đặt thêm các tính năng mới cho
  Component.
- `Client`: đối tượng sử dụng Component với những yêu cầu mở rộng đính kèm.

=> Một interface `component` thiết kế các việc cần làm<br>
=> Một class base `concrete component` triển khai interface đó<br>
=> Tạo các abstract class `decorator` để triển khai sơ bộ interface `component`<br>
=> Tạo các class cụ thể `concrete decorator` để triển khai `decorator` và thêm thắt chức năng mong muốn

## BENEFIT

### PROS

- Có thể mở rộng hành vi của đối tượng mà không cần tạo class con mới.
- Có thể thêm hoặc xoá tính năng của một đối tượng trong lúc thực thi 1 cách linh hoạt.
- Một đối tượng có thể được bao bọc bởi nhiều wrapper cùng một lúc.
- Tuân thủ SRP - Có thể chia nhiều cách thực thi của một phương thức trong một lớp cho nhiều lớp nhỏ hơn.

### CONS

- Khó để xóa một wrapper cụ thể khỏi stack.
- Khó để triển khai decorator theo cách mà phương thức của nó không phụ thuộc vào thứ tự trong stack.

## USE WHEN

- Bạn muốn thay đổi hành vi của một đối tượng mà không cần thay đổi lớp của đối tượng đó.
- Bạn muốn "bổ sung" thêm chức năng mới cho đối tượng mà không ảnh hưởng đến các lớp khác.
- Bạn cần mở rộng chức năng của đối tượng một cách động (dynamic).