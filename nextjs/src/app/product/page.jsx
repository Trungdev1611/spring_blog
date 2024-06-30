'use client'

import React, { useEffect, useState } from 'react'
import { Apiclient } from '../api/Api';
import { Col, Row } from 'antd';
import { useRouter } from 'next/navigation';
import { Card } from 'antd';
import Image from 'next/image';
const { Meta } = Card;



const ProductItem = ({ product }) => {

  const handleProductClick = (id) => {
    router.push(`/product/${id}`);
  };
  return (
    <div onClick={() => handleProductClick(product?.id)}>
      <Card
        hoverable
        style={{
          width: "100%",
          height: 'auto'
        }}
        cover={<Image alt="example" src="/card.png"
          width="0"
          height="0"
          sizes="100vw"
          style={{ width: '100%', height: 'auto' }}
        />}
      >
        <Meta title="Europe Street beat" description="www.instagram.com" />
        <Meta title="Tên cửa hàng" description="Cửa hàng 1" />
      </Card>
    </div>
  )
}

const Products = () => {
  const router = useRouter();
  const [products, setListProducts] = useState([])
  useEffect(() => {
    async function getListProductAllStore() {
      try {
        const data = await Apiclient.get('/products');
        console.log('Data:', data);
        setListProducts(data)
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
    getListProductAllStore()
  }, [])


  return (
    <div className='mt-2'>
      <Row gutter={[32, 24]}>

        {products.map(product => {
          return <Col xs={24} key={product.id} sm={12}
            lg={8} xl={6}
          >
            <ProductItem />
          </Col>
        })}


      </Row>
    </div>
  )
}

export default Products