from kafka.admin import KafkaAdminClient, NewTopic, NewPartitions, ConfigResource, ConfigResourceType

BOOTSTRAP_SERVER = '192.168.1.23:9092'

admin = KafkaAdminClient(bootstrap_servers=BOOTSTRAP_SERVER)

# yeni bir topic oluşturmak
# topics = []
# topics.append(NewTopic(name='kafka_test_admin1', num_partitions=12, replication_factor=1))
# topics.append(NewTopic(name='kafka_test_admin2', num_partitions=6, replication_factor=1))
# topics.append(NewTopic(name='kafka_test_admin3', num_partitions=3, replication_factor=1))

# admin.create_topics(new_topics=topics)

# kullanıcıdan alınan bilgilerle topic oluşturmak
# topics = []
# print("Lütfen Oluşturmak İstediğiniz Topic Bilgilerini Giriniz ")
# topic_name = input('Topic İsmi: ')
# num_partitions = int(input('Partition Sayısı: '))
# replication_factor = int(input('Replication Factor Sayısı: '))
#
# topics.append(NewTopic(name=topic_name, num_partitions=num_partitions, replication_factor=replication_factor))
#
# admin.create_topics(new_topics=topics)

# admin.create_partitions({'kullanici_test_topic': NewPartitions(6)})

# delete_topics = []
# delete_topics.append('kafka_test_admin1')
# delete_topics.append('kafka_test_admin2')
# delete_topics.append('kafka_test_admin3')
#
# admin.delete_topics(delete_topics)
#
# admin.delete_topics(['kafka_test_admin1', 'kafka_test_admin2', 'kafka_test_admin3'])

# Topic Configs Okuma
config_topics = []
config_topics.append(ConfigResource(ConfigResourceType.TOPIC, 'test_partition_python'))
admin.describe_configs(config_topics)
print(admin.describe_configs(config_topics))


