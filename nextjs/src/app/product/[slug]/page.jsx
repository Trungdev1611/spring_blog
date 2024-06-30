'use client'
import React, { useState } from 'react'
import { useParams } from 'next/navigation';
import { Card } from 'antd';
import Image from 'next/image';
import Link from 'next/link';
const ProductItem = () => {
    const params = useParams()
    const [product, setProduct] = useState({})
    console.log("id", params)
    return (
        <Card title="Card title">
            <Card type="inner" title="Inner Card title" extra={  <Link href={`/store/${product.idStore}`}>Store details</Link>}>
                {product.name}
            </Card>
            <Card
                style={{
                    marginTop: 16,
                }}
                type="inner"
                title="Inner Card title"
                extra={<a href="#">More</a>}
            >
                <Image alt="example" src={product.image}
                    width="0"
                    height="0"
                    sizes="100vw"
                    style={{ width: '100%', height: 'auto' }}
                />
                <div>Price: {product.price}</div>
                <div>Discount: {product.discount}</div>
            </Card>
        </Card>
    )
}

export default ProductItem