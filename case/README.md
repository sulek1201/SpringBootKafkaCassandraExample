# Kafka Cassandra Spring boot projesi

Projede createUser servisi mevcuttur. UserDto'dan gelen ilgili alanları user tablosuna kaydettikten sonra kayıt atılan datanın
id'sini ve body'deki followerListesini kafkaya send eder. Kafkayı consume eden listener servisi ilgili dataları alır ve userfollowers tablosuna yazar.


### Docker (Projeyi ayağa kaldırmak için)

- Maven install yaptıktan sonra terminalde Projenin olduğu dizinde "docker-compose up" komutunu koşmak gerekiyor. Sonrasında cassandra kafka ve spring boot ayağa kalkıp haberleşebiliyorlar.(Spring boot ayağa kalktıktan sonra cassandra ayağa kalkmamışsa bir kaç kere restart etmesi gerekebiliyor kendisini)

### Rest servise erişmek

- Projenin altında kafein.postman_collection.json dosyası mevcut. Request ve body'i içinde hazır durumda, dosyayı postmane import edip direk istekler gönderilebilir.