package util;


import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.security.JaasUtils;
import org.apache.kafka.common.serialization.StringSerializer;
import scala.collection.JavaConversions;

import java.util.List;
import java.util.Properties;

/**
 * @author wqkenqing
 * @emai wqkenqingto@163.com
 * @time 2019-07-22
 * @desc
 */
@Slf4j
public class KafkaUtil {

    static ZkUtils zkUtils;
        static String zookeeperStr = "192.168.10.100:2181";
//    static String zookeeperStr = "jd_cloud:32792";
//    static String zookeeperStr = "192.168.10.211:2182";
    //    static String zookeeperStr = "namenode1";
    static Properties props;
    static Properties prop;
    static Properties propz;

    static {

//        props = PropertyUtil.initConfig("kafkap.properties");
//        prop = PropertyUtil.initConfig("kafka.properties");
//        propz = PropertyUtil.initConfig("zk.props");
        zkUtils = ZkUtils.apply(zookeeperStr, 30000, 30000, JaasUtils.isZkSecurityEnabled());
    }


    public static KafkaConsumer<String, String> createConsumer(String address) {
        if (!address.equals("")) {
            prop.put("bootstrap.servers", address);
        }
        return new KafkaConsumer<String, String>(prop);
    }

    public static KafkaConsumer<String, String> createConsumer(String address, String topicName) {
        if (!address.equals("")) {
            prop.put("bootstrap.servers", address);
        }
        if (!topicName.equals("")) {
            prop.put("group.id", topicName);
        }
        return new KafkaConsumer<String, String>(prop);
    }

    public static KafkaProducer<String, String> createProducer() {
        KafkaProducer<String, String> producer;
        producer = new KafkaProducer<String, String>(props);
        return producer;
    }


    public static List<String> getTopicList() {
        List<String> allTopicList = JavaConversions.seqAsJavaList(zkUtils.getAllTopics());
        return allTopicList;
    }

    public static void getTopicListShow(String zookeeperStr) {
        List<String> allTopicList = JavaConversions.seqAsJavaList(zkUtils.getAllTopics());
        allTopicList.forEach(topic -> {
            System.out.println(topic);
        });
    }

    public static void getTopicListShow() {
        List<String> allTopicList = JavaConversions.seqAsJavaList(zkUtils.getAllTopics());
        allTopicList.forEach(topic -> {
            System.out.println(topic);
        });
    }

    public static void deleteTopic(String topic) {
        AdminUtils.deleteTopic(zkUtils, topic);
    }


    public static void createTopic(String topicName) {
// 创建一个单分区单副本名为t1的topic
        AdminUtils.createTopic(zkUtils, topicName, 3, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);
//        zkUtils.close();
        log.info("创建完成.....");
    }

    public static boolean topicIsExist(String topic) {
        boolean res = AdminUtils.topicExists(zkUtils, topic);
        if (res) {
            log.info("topic[{}]已存在", topic);
        }
        return res;
    }

    public static void createTopicList(List<String> tlist) {

    }

    public static void main(String[] args) {
        createTopic("sy_settlement");
    }


}
