"use client";

import React from "react";
import { Button, Checkbox, Form, Input } from "antd";
import './auth.css'
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import Link from "next/link";
const Login = () => {

  const onFinish = (values) => {
    console.log('Success:', values);
  };
  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };


  return (
    <div className="container_auth">
      <div className="container-form">
        <h3 className='heading_auth'>Sign in</h3>
        <Form
          name="normal_login"
          className="form_auth"
          initialValues={{
            remember: true,
          }}
          style={{ width: 400, maxWidth: "100%" }}
          onFinish={onFinish}
        >
          <Form.Item
            name="username"
            rules={[
              {
                required: true,
                message: 'Please input your Username!',
              },
            ]}
          >
            <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Username" />
          </Form.Item>
          <Form.Item
            name="password"
            rules={[
              {
                required: true,
                message: 'Please input your Password!',
              },
            ]}
          >
            <Input
              prefix={<LockOutlined className="site-form-item-icon" />}
              type="password"
              placeholder="Password"
            />
          </Form.Item>
          <Form.Item className="forgotpass">
            <Form.Item name="remember" valuePropName="checked" noStyle>
              <Checkbox>Remember me</Checkbox>
            </Form.Item>

            <a className="login-form-forgot" href="">
              Forgot password
            </a>
          </Form.Item>

          <Form.Item>
            <Button type="primary" htmlType="submit" className="login-form-button">
              Log in
            </Button>
            <br />
            <br />
            Or <Link href="/auth/register">register now!</Link>
          </Form.Item>
        </Form>
      </div>

    </div>
  );
};

export default Login;
