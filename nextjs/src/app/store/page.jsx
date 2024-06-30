'use client'

import React, { useEffect, useState } from 'react'
import { Apiclient } from '../api/Api';
import { Col, Row } from 'antd';
import StoreItem from '../components/storeItem/StoreItem';

const storeData = [
    {
        "id": 1,
        "name": "store1",
        "location": "HaNoi",
        "owner": null
    },
    {
        "id": 2,
        "name": "store2",
        "location": "HaNoi",
        "owner": "Trung123"
    },
    {
        "id": 3,
        "name": "store2",
        "location": "HaNoi",
        "owner": "Trung123"
    }
]

const StoreList = () => {
  const [stores, setListStores] = useState(storeData)

    useEffect(() => {
        async function getAllStoreNotIncludeProducts() {
             try {
                 const response = await Apiclient.get('/products');
                 console.log('Data:', response);
                 setListStores(data)
             } catch (error) {
                 console.error('Error fetching data:', error);
             }
         }
         getAllStoreNotIncludeProducts()
     }, [])
  return (
    <div>
         <Row gutter={[32, 24]}>
         {stores.map(store => {
          return <Col xs={24} key={store.id} lg={12}
            xxl={8}
          >
            <StoreItem id = {store.id}/>
          </Col>
        })}
         </Row>
    </div>
  )
}

export default StoreList