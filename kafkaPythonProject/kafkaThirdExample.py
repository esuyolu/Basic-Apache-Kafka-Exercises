from kafka.admin import KafkaAdminClient, ConfigResource, ConfigResourceType

BOOTSTRAP_SERVER = '192.168.1.23:9092'

admin = KafkaAdminClient(bootstrap_servers=BOOTSTRAP_SERVER)

admin.list_consumer_groups()
print(admin.list_consumer_groups())

admin.describe_consumer_groups('test-consumer-group')
print(admin.describe_consumer_groups(['test-consumer-group']))

admin.list_consumer_group_offsets('test-consumer-group')
print(admin.list_consumer_group_offsets('test-consumer-group'))

config_list = []
config_list.append(
    ConfigResource(
        ConfigResourceType.TOPIC,
        'click_event_data',
        {"retention.ms": "10000"}
    )
)
admin.alter_configs(config_list)

topic_list = admin.list_topics()

print(topic_list)
