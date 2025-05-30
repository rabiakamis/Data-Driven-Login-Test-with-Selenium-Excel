# 📊 Data-Driven Login Test with Selenium & Excel

Bu proje, **Selenium WebDriver**, **Apache POI** ve **Java** kullanarak basit bir login test senaryosunda **data-driven testing** uygulamasıdır.

---

## 🎯 Amaç

- Bir Excel dosyasından kullanıcı adı ve şifreleri okuyarak otomatik giriş denemeleri yapılır.
- Giriş başarılı mı, hatalı mı terminal çıktısı üzerinden görülür.

Test sitesi: [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login)

---

## 🧰 Kullanılan Teknolojiler

- Java
- Selenium WebDriver
- Apache POI
- WebDriverManager
- Maven

---


## 📝 Excel Dosyası

`testdata/credentials.xlsx` adlı dosya aşağıdaki yapıda olmalıdır:

| username   | password              |
|------------|-----------------------|
| tomsmith   | SuperSecretPassword!  |
| wronguser  | wrongpass             |
| admin      | admin123              |

---

## 🚀 Kurulum ve Çalıştırma

1. **Projeyi klonlayın veya oluşturun**
2. `pom.xml` içindeki bağımlılıkları ekleyin ve Maven ile yükleyin:

```bash
mvn clean install


