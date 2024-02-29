

Khi cpu đọc dữ liệu nó sẽ đọc 1 khối bộ nhớ 1 lúc, lưu vào memory cache, 
khi nó truy nạp dữ liệu nó sẽ xem dữ liệu cần có đang nằm trong cache ko?, 
nếu có lấy luôn ( nên tốc độ nhanh ), ko có thì nó lại phải đọc 1 khối dữ liệu khác vào cache rồi dùng. 
Đối với mảng, khi truy xuất theo dòng thì các phần tử mảng sẽ nằm theo thứ tự, mỗi lần đọc dữ liệu, 
cpu đọc cả 1 khối dữ liệu vào, nó sẽ gồm nhiều phần tử mảng vào cache, do đó tốc độ nhanh, 
còn truy xuất theo cột thì sau khi đọc 1 khối bộ nhớ vào cache, xài đc 1 phần tử, rồi lại đọc 1 khối bộ nhớ vào cache, 
xài đc 1 phần tử.... nên nó lâu.


Đúng vậy, ngôn ngữ máy và mã máy là hai khái niệm khác nhau. Ngôn ngữ máy là ngôn ngữ được sử dụng bởi máy tính để thực hiện các tác vụ, và nó được biểu diễn dưới dạng các lệnh máy. Ngôn ngữ máy thường được viết bằng các ký hiệu như các con số và các ký tự chữ cái để biểu diễn các lệnh máy.

Mã máy là mã hóa của ngôn ngữ máy bằng chuỗi các bit 0 và 1, được sử dụng để thực hiện các lệnh máy trên máy tính. Mã máy được tạo ra bằng cách chuyển đổi các lệnh máy từ ngôn ngữ máy sang dạng nhị phân.

Vì vậy, ngôn ngữ máy và mã máy là hai khái niệm khác nhau, tuy nhiên chúng liên quan chặt chẽ tới nhau. Ngôn ngữ máy được biểu diễn bằng các ký hiệu đơn giản hơn, trong khi mã máy được biểu diễn bằng chuỗi các bit 0 và 1 để máy tính có thể hiểu được.