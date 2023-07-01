# Khái niệm:

1. OOP là 1 cách tư duy:

    - Khái quát các vấn đề về đối tượng
    - Cách suy nghĩ của nó khác hoàn toàn với phương pháp lập trình tuyến tính trước đó

2. OOP là 1 phương pháp thiết kế:

    - Từ các bài toán thực tế => các class, interface, properties

3. OOP là ràng buộc giúp tránh lỗi:

    - Tuân thủ quy tắc => tránh lỗi không mong muốn

```
Vì sao người ta cần abstraction?, polymorphism thế nào là đúng?
Từ một bài toán thực tế, làm sao để biết được cần có những class nào?

4 đặc tính trong OOP luôn bổ trợ cho nhau, bạn không có thừa kế thì không thể có đa hình (polymorphism), để đảm bảo dữ liệu được toàn vẹn ta cần có đóng gói... 
Trừu tượng ở đây nói đến việc ta chỉ quan tâm đến chính xác những gì ta cần mà không cần biết đằng sau nó là gì, nó làm thế nào
```

### sự khác nhau giữa object-oriented programming and structure programming
1. Với `OOP` thì mỗi đối tượng sẽ chỉ thao tác dữ liệu của đối tượng đó 
2. Với `SP` thì sẽ không có khái niệm đối tượng, ta chỉ tập trung vào các hàm và các hàm sẽ xử lý input và cho output tùy theo từng cấu trúc dữ liệu 
   > Lambda trong java cũng là 1 cách để lập trình FP<br/>
   
# Phương pháp

1. Danh từ tạo nên lớp và thuộc tính, động từ tạo nên phương thức

   **_Ví dụ:_**
      ````
      Người dùng nhập họ tên và email để đăng ký, hệ thống sẽ kiểm tra xem Email đã có trong hệ thống hay chưa, nếu có rồi sẽ hiển thị thông báo lỗi, 
      nếu chưa có sẽ lưu vào cơ sở dữ liệu và gửi email chúc mừng đến người dùng vừa đăng ký.
      ````

   + Người dùng, họ tên, email, hệ thống, cơ sở dữ liệu... và một số động từ: đăng ký, kiểm tra (email), hiển thị (thông báo lỗi), lưu (vào CSDL), gửi (email chúc mừng)...
   + Các danh từ có giá trị đơn (họ tên, email...) sẽ là thuộc tính (property), các danh từ chứa các thuộc tính sẽ là class.

2. Mỗi lớp chỉ có 1 chức năng

   **_Ví dụ_**
      ````
      - Một class Cart để lưu thông tin giỏ hàng, class CartService để có các thao tác lưu giỏ hàng
      - Class Checkout sẽ có các method tạo đơn ( createOrder ) với tham số là Cart
      ````

3. Một lớp không được phép thay đổi chức năng khi mở rộng (thừa kế)

   ````
   Tức là nếu cùng một tham số, cùng lời gọi hàm... tất cả các điều kiện giống nhau thì phải ra cùng kết quả,
   kể cả trong lớp thừa kế cũng vậy - hay nói cách khác, lớp thừa kế chỉ mở rộng chứ không thay đổi lớp cơ sở.
   ````

4. Tận dụng tối đa tính trừu tượng (abstraction)

   ````
   Trừu tượng ở đây nói đến việc ta chỉ quan tâm đến chính xác những gì ta cần mà không cần biết đằng sau nó là gì, nó làm thế nào
   ````

   - Giảm sự phụ thuộc nhất có thể  
   - Không cần quan tâm các thể hiện (class implements) của nó làm việc ra sao

   **_Ví dụ_**
   ````
   Tưởng tượng nếu lớp CategoryService phải dựa vào lớp RedisCache, và lớp RedisCache lại phải kết nối vào 1 máy chủ Redis để hoạt động, 
   vậy mỗi lần muốn test CategoryService, bạn phải setup một máy chủ Redis, 
   mà bạn cũng không chắc máy chủ Redis đó mỗi lần chạy test có đang ở một trạng thái giống nhau hay không nữa. 
   Trong khi đó, nếu CategoryService chỉ phụ thuộc vào ICache, khi chạy test ta chỉ cần truyền vào 1 MemoryCache là được.
   ````
   
5. Sử dụng Inversion of Control (IoC)
   
   ````
   Là 1 design parttern phổ biến, ý tưởng là các component khi chạy sẽ chỉ cần được cung cấp các tham số, thuộc tính cần thiết là chạy,
   chúng không bao giờ quan tâm tới việc các tham số đó được tạo ra thế nào
   ````

> Cố gắng xác định trách nhiệm(lý do để thay đổi) giúp nhận ra và tạo ra sự trừu tượng tốt hơn code của mình
   
