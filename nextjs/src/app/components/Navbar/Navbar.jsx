"use client";
import './navbar.css'
import React, { useEffect, useState } from 'react'
import { Layout, Menu } from "antd";
import Image from 'next/image';
import { MailOutlined, AppstoreOutlined } from '@ant-design/icons';
import Link from 'next/link';
import { usePathname} from 'next/navigation';

const { Header } = Layout
const items = [
  {
    label: < Link href="/home" rel="noopener noreferrer" >
      Home
    </ Link>
    ,
    key: 'home',
    icon: <MailOutlined />,
  },
  {
    label: <Link href="/product" rel="noopener noreferrer">
      Products
    </Link>,
    key: 'product',
    icon: <MailOutlined />,
  },
  {
    label: <Link href="/store" rel="noopener noreferrer">
      Stores
    </Link>,
    key: 'store',
    icon: <AppstoreOutlined />,
  },

]


const NavBar = () => {
  const [current, setCurrent] = useState('home')
  const pathname = usePathname();
  useEffect(() => {
    console.log(pathname)
    if(pathname.includes("/home")){
      setCurrent("home")
    }
    if(pathname.includes("/product")){
      setCurrent("product")
    }
    if(pathname.includes("/store")){
      setCurrent("store")
    }
    
}, [pathname]);

  const onClick = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
  };
  return (
    <Header className="nav_container">
      <Image
        width={80}
        height={80}
        src={"/logo.png"}
        alt="Picture of the author"
      />
      <Menu
        mode="horizontal"
        onClick={onClick}
        selectedKeys={[current]}
        items={items}
        style={{ flex: 1, minWidth: 0 }}
        className='menu-navbar'
      />
    </Header>

  )
}

export default NavBar