
import React from "react";
import { Card } from "antd";
import Image from "next/image";
import { Descriptions } from "antd";
import { Divider } from "antd";
import Link from "next/link";
const items = [
  {
    key: "1",
    label: "UserName",
    children: "Zhou Maomao",
  },
  {
    key: "2",
    label: "Telephone",
    children: "1810000000",
  },
  {
    key: "3",
    label: "Live",
    children: "Hangzhou, Zhejiang",
  },
  {
    key: "4",
    label: "Remark",
    children: "empty",
  },
  {
    key: "5",
    label: "Address",
    children: "No. 18, Wantang Road, Xihu District, Hangzhou, Zhejiang, China",
  },
];
const StoreItem = ({id}) => {
  return (
    <div>
      <Card title="Shop name">
        <Card
          style={{
            marginTop: 12,
          }}
          type="inner"
          title="Inner Card title"
          extra={<Link href={`/store/${id}`}>More</Link>}
        >
          <Image
            alt="example"
            src="/store.jpg"
            width="0"
            height="0"
            sizes="100vw"
            style={{ width: "100%", height: "auto" }}
          />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nonne
          merninisti licere mihi ista probare, quae sunt a te dicta? Refert
          tamen, quo modo.
        </Card>
        <Divider orientation="left" plain />

        <Descriptions title="" items={items} />
      </Card>
    </div>
  );
};

export default StoreItem;
