grafana: công cụ giám sát với biểu đồ
prometheus: giám sát và phân tích máy tính và app có thể kết hợp với grafana để làm việc
elastic search: thu thập giữ liệu và phân tích, search nhanh
sonar: analyze code, optimize code

## Spring security

- addFilterBefore để thêm 1 filter trước 1 bộ lọc cụ thể
- addFilterAfter để thêm 1 filter sau 1 bộ lọc cụ thể
- Oauth2 Resource server là server chứa các api
- Oauth2 Authorization server là nơi tạo ra accessToken và cũng là nơi check quyền và kiềm tra người dùng( ví dụ như
  keycloak)
- Oauth2 client đóng vai trò là 1 client access đến resource server và phải check quyền thông qua Authorization server
- Khi chúng ta cố gắng xác thực bằng tên người dùng và mật khẩu, Spring Security tìm kiếm `AuthenticationProvider` thích
  hợp để xử lý quá trình xác thực.

## Hibernate

- mỗi 1 PersistenceUnit đại diện cho 1 EntityManagerFactory
- session là implement của entityManager và sessionFactory là implement của EntityMangerFactory
- mỗi `1 dataSource` sẽ tạo được `nhiều EntityManagerFactory`
- `EntityManagerFactory` sẽ phụ trách việc kết nối tới database nhờ dataSource
- mỗi `1 EntityManagerFactory` quản lý `nhiều entityManager`

#### @EnableTransactionManagement:

- có e mode AdviceMode:
    - PROXY: là cấu hình default của spring
    - ASPECTJ: là bật aop và manual config tự mở transaction và tự commit hoặc là rollback thông qua @Aspect, @PointCut,
      @Before, @After, @Around, ...

## Operator System

- Mỗi core sẽ quản lý 1 số lượng logical processor
- mỗi logical processor sẽ tương ứng với 1 thread
- CPU cache chính là bộ nhớ của core
    - `L1`: bộ nhớ trong 1 core
    - `L2`: bộ nhớ chia sẻ cho các cores trong cùng 1 cpu
    - `L3`: bộ nhớ chia sẻ cho các cores trong toàn bộ cpu
- CPU (Central Processing Units): bộ trung tâm xử lý của máy tính
    - clock speed: tốc độ xung nhịp, tốc độ của CPU
    - cores: số lượng nhân(số lượng các đơn vị xử lý độc lập trong CPU)
- GPU (Graphics Processing Unit) là các thành phần phần cứng chuyên biệt được thiết kế để tăng tốc xử lý đồ họa và các
  nhiệm vụ tính toán song song.
- Lập trình song song trên GPU tức là chúng ta sẽ đưa các data từ CPU về GPU để xử lí/tính toán bằng ngôn ngữ Cuda C/C++

## Webservice

- REST: REpresentational State Transfer.
- CSRF: là 1 loại tấn công web bằng việc lợi dụng phiên đăng nhập của client và gửi request độc đến server
- Authentication: là xác thực người dùng
- Authorization: xem client có được quyền gì
- có thể để các file tính .html, .css, .js lên cloud để server không phải chịu tải
- cross-origin resource sharing - CORS: là các chính sách bảo mất của 1 web server khi cho nguồn(origin) khác truy cập
  tài nguyên

## Batch processing và Stream processing

- Batch processing: xử lý dữ liệu theo lô, xử lý dl lớn và không cần tương tác với client trong quá trình xử lý
    - thường được thực hiện với các tác vụ cần thời gian xử lý lớn
    - các công cụ hỗ trợ hàng đầu: Hadoop, Spark, Hive và MapReduce
- Stream processing: xử lý dữ liệu gần như ngay lập tức sau khi nó được tạo ra
    - hữu ích khi phân tích dữ liệu thời gian thực
    - các công cụ hỗ trợ hàng đầu: Apache Kafka, Apache Flink, Storm và Google Cloud Dataflow

## Spring

- @Autowired trên field là không được khuyến khích, do nó sử dụng Java reflection để inject. Chúng ta nên cân nhắc đổi
  qua dùng inject theo kiểu constructor hoặc setter.

- nếu cả 2 bean phụ thuộc vòng lẫn nhau thông qua constructor thì phải có 1 bean dùng setter để inject để tránh spring
  không biết tạo bean nào trước
- nguyên tắc xử lý exception là: Không bao giờ được trả về chi tiết lỗi (error details) cho client (che giấu lỗi system)
    - Business exception không cần log ra làm gì
    - Technical exception phải log ra để dễ dàng đọc được và debug
  > do vậy ta cần chia loại exception để trả về cho client và log hệ thống

## Webflux

- Backpressure là một khái niệm quan trọng trong lập trình reactive, đặc biệt là khi làm việc với các luồng dữ liệu có
  tốc độ khác nhau. Nó đề cập đến khả năng điều chỉnh tốc độ tiếp nhận dữ liệu của người tiêu thụ (subscriber) để phù
  hợp với tốc độ sản xuất dữ liệu của nguồn (publisher).

- Khi một nguồn dữ liệu (như một luồng hoặc một publisher) sản xuất dữ liệu với tốc độ nhanh hơn so với khả năng xử lý
  của người tiêu thụ, backpressure cho phép người tiêu thụ thông báo cho nguồn để giảm tốc độ sản xuất hoặc tạm dừng sản
  xuất dữ liệu cho đến khi người tiêu thụ sẵn sàng tiếp nhận.
- sử dụng TransactionalOperator để bọc 1 transaction và quản lý commit hay rollback trong đó

````java
@Configuration
public class TransactionConfig {
    private final DatabaseClient databaseClient;

    public TransactionConfig(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        // Cấu hình và trả về Reactive R2DBC ConnectionFactory
    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }

    @Bean
    public TransactionalOperator transactionalOperator(ReactiveTransactionManager transactionManager) {
        return TransactionalOperator.create(transactionManager);
    }

    @Bean
    public UserRepository userRepository(DatabaseClient databaseClient) {
        return new UserRepository(databaseClient);
    }
}
````