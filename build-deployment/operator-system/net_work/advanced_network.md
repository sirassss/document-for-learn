### PROTOCOL

- `HTTP/2`: Giao thức HTTP phiên bản 2, được phát triển bởi IETF, nhưng có sự đóng góp đáng kể của Google. HTTP/2 có khả
năng tăng tốc độ tải trang web, giảm thời gian phản hồi của máy chủ và tăng hiệu quả sử dụng tài nguyên mạng.

- `QUIC`: Giao thức truyền tải UDP được phát triển bởi Google. QUIC có khả năng tăng tốc độ tải trang web, đặc biệt là trên
mạng không ổn định. Nó sử dụng mã hóa TLS và định tuyến động để cải thiện bảo mật và hiệu suất.

- `SPDY`: Giao thức truyền tải HTTP phiên bản tiên tiến hơn, được phát triển bởi Google. SPDY cũng có khả năng tăng tốc độ
tải trang web, giảm thời gian phản hồi và tiết kiệm băng thông.


### Truyền gói tin trong network

- các gói tin sẽ được đóng gói vào các frame trước khi được gửi đi
- mỗi gói tin sẽ có thông tin ở phần header, vd: IP, TCP, UDP, chứa các thông tin định tuyến và kiểm soát quá trình truyền tải
- mỗi gói tin sẽ được chia vào frame tùy vào kích thước của gói tin và kích thước của frame
- mỗi frame cũng sẽ được thêm header để truyền đi
- các frame sẽ truyền qua network dưới dạng các bit
- các frame đến đích sẽ được giải mã và lấy ra gói tin ban đầu