package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.LikedDislikedCommentary;

import java.util.List;
/**
 * Interface {@link ILikedDislikedCommentaryService} do serviço CommentaryService.
 * @author ArturBarreto
 */
public interface ILikedDislikedCommentaryService {
    public void createLikedDislikedCommentary(LikedDislikedCommentary likedDislikedCommentary, Long commentaryId);
    public List<LikedDislikedCommentary> findAll();
}
