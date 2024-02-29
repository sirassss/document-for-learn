## CONCEPT

- Thuộc nhóm Structural
- Cung cấp 1 interface chung đơn giản thay cho 1 nhóm các giao diện có trong hệ thống con nhằm giấu đi sự phức tạp của
  hệ thống và giúp client dễ sử dụng hơn
- Phương thức của Facade sẽ xử lý các đoạn code được sử dụng với nhiều, lặp lại

## PURPOSE

- Giấu đi sự phức tạp của hệ thống và giúp client dễ sử dụng hơn

## ARCHITECTURE

![ar](ar.webp)

- `Facade`: Facade nắm rõ được hệ thống con nào đảm nhiệm việc đáp ứng yêu cầu của client, nó sẽ chuyển yêu cầu của client
  đến các đối tượng hệ thống con tương ứng.
- `Addition Facade`: có thể được tạo ra để tránh việc làm phức tạp một facade. Có thể được sử dụng bởi cả client và
  facade.
- `Complex Subsystems`: Bao gồm nhiều object khác nhau, được cài đặt các chức năng của hệ thống con, xử lý công việc được
  gọi bởi Facade. Các lớp này không cần biết Facade và không tham chiếu đến nó.
- `Client`: Đối tượng sử dụng Facade để tương tác với các subsystem thay vì gọi subsystem trực tiếp

## BENEFIT

### PROS

- Giảm bớt code bị trùng lặp
- Đơn giản hóa việc xử lý của client
- Tăng khả năng độc lập, giảm sự phụ thuộc


### CONS

- Class Facade của bạn có thể trở lên quá lớn, làm quá nhiều nhiệm vụ với nhiều hàm chức năng trong nó.
- Dễ bị phá vỡ các quy tắc trong SOLID.
- Việc sử dụng Facade cho các hệ thống đơn giản, ko quá phức tạp trở nên dư thừa.

## USE WHEN

- Muốn gom nhóm chức năng lại để Client dễ sử dụng
- Giảm sự phụ thuộc giữa các service con
- Tăng khả năng độc lập và khả chuyển
- Khi người sử dụng phụ thuộc nhiều vào các lớp cài đặt
- Đóng gói nhiều chức năng, che giấu thuật toán phức tạp.
- Cần một interface không rắc rối mà dễ sử dụng.