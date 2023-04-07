import React, { useState } from 'react';
import axios from 'axios';

const EditInfo = () => {
  const [memberpass, setMemberPass] = useState('');
  const [membername, setMemberName] = useState('');
  const [memberphone, setMemberPhone] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    // 서버에 전송할 데이터
    const data = {
      memberpass,
      membername,
      memberphone,
    };

    // axios를 사용하여 데이터를 전송
    axios
      .post('/api/update-member-info', data)
      .then((response) => {
        // 데이터 전송 후에 할 일
        console.log(response.data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        비밀번호:
        <input
          type='password'
          value={memberpass}
          onChange={(event) => setMemberPass(event.target.value)}
        />
      </label>
      <label>
        이름:
        <input
          type='text'
          value={membername}
          onChange={(event) => setMemberName(event.target.value)}
        />
      </label>
      <label>
        전화번호:
        <input
          type='tel'
          value={memberphone}
          onChange={(event) => setMemberPhone(event.target.value)}
        />
      </label>
      <button type='submit'>수정하기</button>
    </form>
  );
};

export default EditInfo;
