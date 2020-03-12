package com.study.demo.ifs;

import com.study.demo.model.network.Header;
import com.study.demo.model.network.request.UserApiRequest;
import com.study.demo.model.network.response.UserApiResponse;

public interface CrudInterface<Req, Res> { // generic으로 수정하여 여러 api controller를 같은 형식으로 만들수 있도록

    Header<Res> create(Req request); // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Req request);

    Header delete(Long id);
}
