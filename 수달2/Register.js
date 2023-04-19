import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { baseUrl } from "../../apiurl";
import axios from "axios";
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

const Register = () => {
  const navigator = useNavigate();
  const [members, setMembers] = useState({
    membeEmail: "",
    memberPass: "",
    profileImage: "",
    memberName: "",
    gender: "",
  });

  const config = { headers: { "Content-Type": "application/json" } };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("memberEmail", members.memberEmail);
    formData.append("memberPass", members.memberPass);
    formData.append("memberName", members.memberName);
    formData.append("gender", members.gender);
    formData.append("profileImage", members.profileImage);
    axios
      .post(`${baseUrl}/register`, formData, config)
      .then((response) => {
        console.log(response.data);
        setMembers({
          memberEmail: "",
          memberPass: "",
          profileImage: "",
          memberName: "",
          gender: "",
        });
        navigator("/");
      })
      .catch((err) => {
        console.error(err.message);
      });
  };

  // 파일 선택 창 추가
  const [previewUrl, setPreviewUrl] = useState(null);

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    reader.onloadend = () => {
      setPreviewUrl(reader.result);
      setMembers((prevState) => ({
        ...prevState,
        profileImage: reader.result,
      }));
    };
    reader.readAsDataURL(file);
  };

  const handleChange = (e) => {
    setMembers({ ...members, [e.target.name]: e.target.value });
    console.log(members);
  };

  return (
    <>
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
                <Form onSubmit={handleSubmit} encType="multipart/form-data">
                  {/* 파일 선택 창 추가 */}
                  <FormGroup>
                    <Label for="profileImage">프로필 이미지</Label>
                    <Input
                      type="file"
                      name="profileImage"
                      id="profileImage"
                      accept="image/*"
                      onChange={handleImageChange}
                    />
                    {previewUrl && (
                      <img src={previewUrl} alt="프로필 이미지 미리보기" />
                    )}
                  </FormGroup>
                  <FormGroup>
                    <Label for="email">이메일</Label>
                    <Input
                      type="email"
                      name="memberEmail"
                      id="email"
                      value={members.email}
                      onChange={handleChange}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="password">비밀번호</Label>
                    <Input
                      type="password"
                      name="memberPass"
                      id="password"
                      value={members.password}
                      onChange={handleChange}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="password2">비밀번호 확인</Label>
                    <Input
                      type="password"
                      name="password2"
                      id="password2"
                      onChange={handleChange}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="name">이름</Label>
                    <Input
                      type="text"
                      name="memberName"
                      id="name"
                      value={members.name}
                      onChange={handleChange}
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
                          checked={members.gender === "male"}
                          onChange={handleChange}
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
                          checked={members.gender === "female"}
                          onChange={handleChange}
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
};

export default Register;
