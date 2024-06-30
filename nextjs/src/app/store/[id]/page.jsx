'use client'
import React, { useEffect, useState } from 'react'
import { useParams } from 'next/navigation';
import { Card } from 'antd';
import Image from 'next/image';
import Link from 'next/link';
import ListItemStore from '@/app/components/ListItemStore/ListItemStore';
const SingleStoreDetail = () => {
    const params = useParams()
    const [store, setStore] = useState({})
    console.log("id", params)

    useEffect(() => {
        async function GetDetailStoreIncludeProductsById() {
            try {
                const response = await Apiclient.get(`/stores/${params.id}`);
                console.log('Data:', response);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }
        GetDetailStoreIncludeProductsById()
    }, [params.id])
    return (
        <Card >

            <Card
                style={{
                    marginTop: 16,
                }}
                type="inner"
                title="Shop name"
            >
                <Image alt="example" src={store.image || "/store.jpg"}
                    width="0"
                    height="0"
                    sizes="100vw"
                    style={{ width: '100%', height: 'auto' }}
                />
                <div>Price: {store.price}</div>
                <div>Discount: {store.discount}</div>

            </Card>

            <Card>
                <h2>Danh sách sản phẩm</h2>

            </Card>

            <ListItemStore />
        </Card>
    )
}

export default SingleStoreDetail