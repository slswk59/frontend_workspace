import axios from "axios";
import { useEffect, useState } from "react";
import { baseUrl } from "../../Apiurl";
import { useNavigate } from "react-router-dom";

const EditInfo = () => {
  const navigator = useNavigate();

  const [member, setMember] = useState({
    password: "",
    name: "",
    nickname: "",
    profileImage: null,
  });

  const { password, name, nickname, profileImage } = member;

  const config = {
    headers: {
      "Content-Type": "application/json",
      Authorization: localStorage.getItem("Authorization"),
    },
  };

  const info = async () => {
    return await axios
      .get(`${baseUrl}/member/editinfo/${localStorage.email}`, config)
      .then((response) => {
        setMember({ ...response.data, password: "" });
      });
  };

  useEffect(() => {
    info();
  }, []);

  const [passwordCheck, setPasswordCheck] = useState("");

  const passChang = (e) => {
    e.preventDefault();
    if (password !== e.target.value) setPasswordCheck("비밀번호 불일치");
    else setPasswordCheck("비밀번호 일치");
  };

  const handleValueChange = (e) => {
    e.preventDefault();
    setMember({ ...member, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    if (!password) {
      alert("비밀번호를 입력하세요.");
      return;
    }

    const formData = new FormData();
    formData.append("profileImage", member.profileImage);

    const response = await axios.post(`${baseUrl}/image/upload`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
        Authorization: localStorage.getItem("Authorization"),
      },
    });
    const profile_path = response.data.path;

    await axios.post(
      `${baseUrl}/profile/update`,
      { ...member, profile_path },
      config
    );

    localStorage.setItem("name", name);
    localStorage.setItem("nickname", nickname);
    window.location.replace("/");
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = (e) => {
      setMember({
        ...member,
        profileImage: e.target.result,
      });
    };
  };

  return (
    <div className="container">
      <form onSubmit={onSubmit}>
        <div className="container">
          <h1>회원 수정</h1>
          <div className="form-group mb-1">
            <input
              type="email"
              className="form-control"
              name="email"
              placeholder="이메일"
              value={localStorage.email}
              readOnly
            />
          </div>
          <div className="form-group mb-1">
            <input
              type="password"
              className="form-control"
              name="password"
              placeholder="비밀번호"
              value={password}
              onChange={handleValueChange}
            />
          </div>

          <div className="form-group mb-1">
            <input
              type="password"
              className="form-control"
              name="password2"
              placeholder="비밀번호 확인"
              onChange={passChang}
            />
            <span>{passwordCheck}</span>
          </div>

          <div className="form-group mb-1">
            <input
              type="text"
              className="form-control"
              name="name"
              placeholder="이름"
              value={name}
              onChange={handleValueChange}
            />
          </div>

          <div className="form-group mb-1">
            <input
              type="text"
              className="form-control"
              name="nickname"
              placeholder="닉네임"
              value={nickname}
              onChange={handleValueChange}
            />
          </div>

          <div className="form-group mb-1">
            <label htmlFor="profileImage">프로필 이미지</label>
            <input
              type="file"
              className="form-control"
              name="profileImage"
              accept="image/*"
              onChange={handleFileChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            회원정보 수정
          </button>
        </div>
      </form>
    </div>
  );
};

export default EditInfo;
