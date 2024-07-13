from kafka import KafkaConsumer, TopicPartition

BOOTSTRAP_SERVER = '192.168.1.23:9092'

consumer = KafkaConsumer(bootstrap_servers=BOOTSTRAP_SERVER, auto_offset_reset='earliest')

# consumer da istenilen partition'a bağlanıp sadece o partition'dan veri çekmek istersek .assign() metodu kullanılmalıdır
consumer.assign([TopicPartition('users', 2), TopicPartition('users', 6), TopicPartition('users', 12), TopicPartition('test_partition_python', 0)])

for msg in consumer:
    print(msg)
    consumer.commit() # python kafka'ya okuduğu bilgisini gönderir

# assign metodu bir komut alırken, assignment metodu aldığı komut bilgisini istediğimiz zaman bilgi olarak dönmesi işlemini sağlar
consumer.assignment()
print(consumer.assignment())

consumer.bootstrap_connected()
print(consumer.bootstrap_connected())

messages = consumer.poll(max_records=5)
count = 1
for topic_data, consumer_record in messages.items():
    for i in consumer_record:
        print(count, i.value.decode())
        count += 1

consumer.position(TopicPartition('users', 2))
print(consumer.position(TopicPartition('users', 2)))

consumer.seek(TopicPartition('users', 12), 4)
for msg in consumer:
    print(msg)

consumer.subscribe(['users', 'test_partition_python'])
for msg in consumer:
    print(msg)

regex = "^users-[0-9]+$"
consumer.subscribe(pattern=regex)
for msg in consumer:
    print(msg)