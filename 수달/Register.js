import React, { useState } from "react";
import {
  Card,
  Button,
  Form,
  FormGroup,
  Label,
  Input,
  FormFeedback,
  Container,
  Row,
  Col,
} from "reactstrap";

function Register() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [name, setName] = useState("");
  const [gender, setGender] = useState(""); // 'male', 'female' 중 하나의 값

  const handleSubmit = (event) => {
    event.preventDefault();
    // 회원가입 정보를 서버로 전송하는 로직
  };
  return (
    <>
      {/* <IndexNavbar /> */}
      <div
        className="page-header"
        style={{
          backgroundImage: "url(" + require("assets/img/login-image.jpg") + ")",
        }}
      >
        <div className="filter" />
        <Container>
          <Row>
            <Col className="ml-auto mr-auto" lg="4">
              <Card className="card-register ml-auto mr-auto">
                <h3 className="title mx-auto">회원가입</h3>
                <div className="social-line text-center"></div>
                <Form onSubmit={handleSubmit}>
                  <FormGroup>
                    <Label for="email">이메일</Label>

                    <Input
                      type="email"
                      name="email"
                      id="email"
                      value={email}
                      onChange={(event) => setEmail(event.target.value)}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="password">비밀번호</Label>
                    <Input
                      type="password"
                      name="password"
                      id="password"
                      value={password}
                      onChange={(event) => setPassword(event.target.value)}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="password2">비밀번호 확인</Label>
                    <Input
                      type="password"
                      name="password2"
                      id="password2"
                      value={password2}
                      onChange={(event) => setPassword2(event.target.value)}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="name">이름</Label>
                    <Input
                      type="text"
                      name="name"
                      id="name"
                      value={name}
                      onChange={(event) => setName(event.target.value)}
                    />
                  </FormGroup>
                  <FormGroup tag="fieldset">
                    <legend>성별</legend>
                    <FormGroup check>
                      <Label check>
                        <Input
                          type="radio"
                          name="gender"
                          value="male"
                          checked={gender === "male"}
                          onChange={(event) => setGender(event.target.value)}
                        />{" "}
                        남성
                      </Label>
                    </FormGroup>
                    <FormGroup check>
                      <Label check>
                        <Input
                          type="radio"
                          name="gender"
                          value="female"
                          checked={gender === "female"}
                          onChange={(event) => setGender(event.target.value)}
                        />{" "}
                        여성
                      </Label>
                    </FormGroup>
                  </FormGroup>
                  <Button
                    type="submit"
                    block
                    className="btn-round"
                    color="danger"
                  >
                    회원가입
                  </Button>
                </Form>
              </Card>
            </Col>
          </Row>
        </Container>
        <div className="footer register-footer text-center">
          <h6>
            © {new Date().getFullYear()}, made with{" "}
            <i className="fa fa-heart heart" /> by Creative Tim
          </h6>
        </div>
      </div>
    </>
  );
}

export default Register;
