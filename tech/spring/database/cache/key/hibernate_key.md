## CACHE MODE

- `IGNORE`: Chế độ này làm cho Hibernate bỏ qua bất kỳ cache nào và luôn thực hiện truy vấn mới mỗi khi cần. Kết quả
  truy vấn không được lưu trữ trong cache và cache không được sử dụng.

- `NORMAL`: Đây là chế độ mặc định của Hibernate. Khi sử dụng chế độ này, Hibernate sẽ kiểm tra cache trước khi thực
  hiện truy vấn. Nếu kết quả truy vấn đã được lưu trong cache, Hibernate sẽ trả về kết quả từ cache thay vì thực hiện
  truy vấn mới. Nếu kết quả không có trong cache, Hibernate sẽ thực hiện truy vấn và lưu kết quả vào cache để sử dụng
  cho các lần truy vấn tiếp theo.

- `GET`: Chế độ này chỉ áp dụng cho các phương thức session.get() hoặc session.load(). Khi sử dụng chế độ này, Hibernate
  sẽ kiểm tra cache trước khi truy vấn đối tượng. Nếu đối tượng đã tồn tại trong cache, Hibernate sẽ trả về đối tượng từ
  cache thay vì truy vấn cơ sở dữ liệu. Nếu đối tượng không có trong cache, Hibernate sẽ thực hiện truy vấn và lưu đối
  tượng vào cache để sử dụng cho các lần truy vấn tiếp theo.

- `PUT`: Chế độ này chỉ áp dụng cho các phương thức session.save(), session.update() và session.saveOrUpdate(). Khi sử
  dụng chế độ này, Hibernate sẽ lưu đối tượng vào cache sau khi thực hiện các phương thức trên. Điều này cho phép
  Hibernate sử dụng cache để truy vấn đối tượng sau này mà không cần truy vấn cơ sở dữ liệu.

- `REFRESH`: Chế độ này yêu cầu Hibernate luôn luôn truy vấn cơ sở dữ liệu để lấy kết quả mới nhất cho mỗi lần truy vấn.
  Kết quả truy vấn không được lưu trữ trong cache và cache không được sử dụng.

## SCROLL MODE

- `FORWARD_ONLY`: Đây là chế độ mặc định khi sử dụng phương thức scroll() trong Hibernate. Khi sử dụng chế độ này, bạn
  chỉ có thể duyệt qua kết quả truy vấn theo chiều thuận (từ đầu đến cuối) mà không thể quay lại hoặc nhảy tới các bản
  ghi trước đó. Điều này là hữu ích khi bạn chỉ cần truy vấn và xử lý từng bản ghi một theo thứ tự từ đầu đến cuối.

- `SCROLL_SENSITIVE`: Chế độ này cho phép bạn di chuyển qua lại và nhảy tới các bản ghi trong kết quả truy vấn. Bạn có
  thể sử dụng phương thức scroll() để cuộn qua kết quả theo cả hai chiều (thuận và nghịch) và cũng có thể sử dụng phương
  thức absolute() hoặc relative() để nhảy tới các bản ghi cụ thể.

- `SCROLL_INSENSITIVE`: Chế độ này tương tự như SCROLL_SENSITIVE, tuy nhiên, nó không nhạy cảm đối với các thay đổi dữ
  liệu trong cơ sở dữ liệu. Điều này có nghĩa là nếu dữ liệu trong cơ sở dữ liệu thay đổi trong khi bạn đang duyệt qua
  kết quả truy vấn, các thay đổi đó sẽ không được phản ánh trong kết quả cuộn.