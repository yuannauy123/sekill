-- 初始化数据库

-- 创建数据库
CREATE database seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
create table seckill(
  seckill_id  bigint not null auto_increment comment '商品库存id',
  name varchar(120) not null comment '商品名称',
  stock int not null comment '库存数量',
  start_time timestamp not null comment '秒杀开始时间',
  end_time timestamp not null comment '秒杀结束时间',
  create_time timestamp not null default current_timestamp comment '商品创建时间',
  primary key (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)ENGINE=InnoDB auto_increment=1000 default charset=utf8 comment='秒杀库存表';

-- 秒杀库存表初始化数据
insert into
  seckill(name,stock,start_time,end_time)
values
  ('1000元秒杀iPhoneX',100,'2018-05-02 00:00:00','2018-05-04 00:00:00'),
  ('1000元秒杀iPhone8',200,'2018-05-02 00:00:00','2018-05-04 00:00:00'),
  ('100元秒杀iPad',100,'2018-05-02 00:00:00','2018-05-04 00:00:00'),
  ('100元秒杀华为P20Pro',200,'2018-05-02 00:00:00','2018-05-04 00:00:00'),
  ('100元秒杀小米6X',300,'2018-05-02 00:00:00','2018-05-04 00:00:00');

-- 创建用户秒杀成功明细表
create table user_seckill(
  seckill_id bigint not null comment '秒杀商品id',
  user_id bigint not null comment '用户id',
  seckill_time timestamp not null default current_timestamp comment '成功秒杀时间',
  state tinyint not null default -1 comment '状态标识：-1：无效 0：成功 1：已付款 2：已发货',
  primary key (seckill_id,user_id),
  key idx_seckill_time(seckill_time)
)ENGINE=InnoDB  default charset=utf8 comment='秒杀成功明细表';

