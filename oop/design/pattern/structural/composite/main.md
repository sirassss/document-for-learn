## CONCEPT

- Thuộc nhóm Structural
- Tổng hợp những đối tượng có quan hệ với nhau để tạo ra thành phần lớn hơn
- Cho phép tương tác với tất cả đối tượng trong mẫu tương tự nhau


## PURPOSE

- Xử lý các component cấp thấp và cao một cách đồng nhất
  - Áp dụng đệ quy thêm hoặc loại bỏ phần tử mà không ảnh hưởng cấu trúc chung

## ARCHITECTURE

![ar](ar.webp)

- `Component`: là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành phần tham
  gia vào mẫu này
- `Leaf`: là lớp hiện thực (implements) các phương thức của Component - các object không có con.
- `Composite`: lưu trữ tập hợp các Leaf và cài đặt các phương thức của Component. Composite cài đặt các phương thức được
  định nghĩa trong interface Component bằng cách ủy nhiệm cho các thành phần con xử lý.

- Có 1 interface hoặc abstract class `component` để quy định các method tham gia
- `Composite` gom tập hợp của các `leaf` hay còn được gọi là `root`
- Trong `root` sẽ `để quy` để truy vào các `leaf`(`lá`)
- `leaf` cũng sẽ triển khai component và cũng là điển dừng của `đệ quy` thực hiện công việc cuối cùng

## BENEFIT

### PROS

- Có thể làm việc với các cấu trúc cây phức tạp thuận tiện hơn.
- Áp dụng O/C principle

### CONS

- Code phức tạp hơn

## USE WHEN

- Bạn muốn đối xử với một nhóm các đối tượng như thể chúng là một đối tượng duy nhất.
- Bạn muốn tạo cấu trúc phân cấp cho phép xử lý các đối tượng cấp cao và thấp như nhau.
- Bạn muốn áp dụng đệ quy cho phép thêm hoặc loại bỏ các phần tử mà không làm thay đổi cấu trúc chung.
