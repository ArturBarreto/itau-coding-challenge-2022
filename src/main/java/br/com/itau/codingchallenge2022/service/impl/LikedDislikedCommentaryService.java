package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.model.LikedDislikedCommentary;
import br.com.itau.codingchallenge2022.repository.LikedDislikedCommentaryRepository;
import br.com.itau.codingchallenge2022.service.ILikedDislikedCommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikedDislikedCommentaryService implements ILikedDislikedCommentaryService {

    @Autowired
    private LikedDislikedCommentaryRepository likedDislikedCommentaryRepository;

    @Override
    public void createLikedDislikedCommentary(LikedDislikedCommentary likedDislikedCommentary, Long commentaryId) {
        likedDislikedCommentary.setCommentaryId(commentaryId);
        likedDislikedCommentaryRepository.save(likedDislikedCommentary);
    }

    @Override
    public List<LikedDislikedCommentary> findAll() {
        return likedDislikedCommentaryRepository.findAll();
    }


}
