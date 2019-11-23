package com.alax.Service;

import com.alax.dto.QuestionDTO;
import com.alax.mapper.QuestionMapper;
import com.alax.mapper.UserMapper;
import com.alax.model.Question;
import com.alax.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: drew
 * date:2019/11/23
 * time:20:02
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @return
     */
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            /*通过getreator拿到user对象*/
            User user =userMapper.findById(question.getCreator());
             /*将question转换成questionDTO*/
            QuestionDTO questionDTO = new QuestionDTO();
            /*属性复制到questionDto*/
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        return questionDTOList;
    }
}
