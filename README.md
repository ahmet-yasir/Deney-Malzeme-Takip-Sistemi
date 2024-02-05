# Deney-Malzeme-Takip-Sistemi

Yazılan Sınıflar  
  
Envanter: Soyut bir sınıf olarak tanımlanmıştır. Deney malzemelerinin dosyalarını ve arraylistlerini oluşturmak ve üzerinde işlem yapmak için kullanılmıştır.  
App: Kullanıcı arayüzünü başlatmak için kullanılmıştır.  
Bilesikler: Bileşik türündeki deney malzemelerinin değişkenlerini içeren sınıftır. Envanter soyut sınıfının alt sınıfıdır. ITekrar_Kullanilabilirlik interface’ini implement eder. Bilesikler nesnesi oluşturmak ve envanter üzerinde ekleme-çıkartma işlemi yapmak için kullanılmıştır.  
Deney_Araclari: Hacmi olan deney malzemelerinin değişkenlerini içeren sınıftır. Envanter soyut sınıfının alt sınıfıdır. ITekrar_Kullanilabilirlik interface’ini implement eder. Deney_Araclari nesnesi oluşturmak ve envanter üzerinde ekleme-çıkartma işlemi yapmak için kullanılmıştır.  
Deney_Ekipmanları: Hacmi olmayan deney malzemelerinin değişkenlerini içeren sınıftır. Envanter soyut sınıfının alt sınıfıdır. ITekrar_Kullanilabilirlik interface’ini implement eder. Deney_Ekipmanlari nesnesi oluşturmak ve envanter üzerinde ekleme-çıkartma işlemi yapmak için kullanılmıştır.  
Elementler: Element türündeki deney malzemelerinin değişkenlerini içeren sınıftır. Envanter soyut sınıfının alt sınıfıdır. ITekrar_Kullanilabilirlik interface’ini implement eder. Elementler nesnesi oluşturmak ve envanter üzerinde ekleme-çıkartma işlemi yapmak için kullanılmıştır.  
EnvantereEkleController: Kullanıcı arayüzündeki envantere ekleme kısmındaki arayüz nesnelerinin kontrolü için kullanılmıştır.  
EnvanteriDuzenleController: Kullanıcı arayüzündeki envanteri düzenleme kısmındaki arayüz nesnelerinin kontrolü için kullanılmıştır.  
ITekrar_Kullanilabilirlik: İnterface olarak oluşturulmuştur. Deney malzemelerinin tekrar kullanılabilme özelliğini gösterir.  
Malzeme_Takip: Test sınıfıdır.  
PrimaryController: Kullanıcı arayüzündeki ilk açılan ekrandaki arayüz nesnelerinin kontrolü için kullanılmıştır.  
   
Kullanılan Nesneler 
  
Elementler: Envantere element türündeki deney malzemeleri üzerinde işlem yaparken kullanılmıştır.  
Bilesikler: Envantere bileşik türündeki deney malzemeleri üzerinde işlem yaparken kullanılmıştır.  
Deney_Araclari: Envantere hacmi olan deney malzemeleri üzerinde işlem yaparken kullanılmıştır.  
Deney_Ekipmanlari: Envantere hacmi olmayan deney malzemeleri üzerinde işlem yaparken kullanılmıştır.  
ArrayList<>: Deney malzemelerinin saklanması için kullanılmıştır  
File: Eklenen malzemeler için dosya oluşturulmasında kullanılmıştır.  
FileWritter ve BufferedWritter: Eklenen deney malzemelerin dosyaya yazılmasında kullanılmıştır.  
FileReader ve BufferedReader: Eklenen deney malzemelerin yazıldığı dosyayı okumak için kullanılmıştır.   
Scene, Stage ve FXMLLoader : Kullanıcı arayüz ekranı için kullanılmıştır.  
Button: Kullanıcı arayüzündeki butonların gerekli metotları çağırması için kullanılmıştır.  
Label: Kullanıcı arayüzünde, kullanıcıya bilgi vermek için kullanılmıştır.  
TextField: Kullanıcı arayüzünde kullanıcıdan giriş almak için kullanılmıştır.  
TextArea: Kullanıcı arayüzünde eklenmiş deney malzemelerini kullanıcıya göstermek için kullanılmıştır.  
ComboBox: Envantere ekleme ekranında farklı türdeki deney malzemeleri arasındaki geçişi sağlamak için kullanılmıştır.  
Exception: Hata ayıklamada kullanılmıştır.   
