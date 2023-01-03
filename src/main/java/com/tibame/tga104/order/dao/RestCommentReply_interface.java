package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.RestCommentReplyVO;

public interface RestCommentReply_interface {

	List<RestCommentReplyVO> getNotNullComment(RestCommentReplyVO restCommentReplyVO);

	List<RestCommentReplyVO> getNullComment();

	List<RestCommentReplyVO> getForMemberNullComment(RestCommentReplyVO restCommentReplyVO);

	List<RestCommentReplyVO> getForMemberNotNullComment(RestCommentReplyVO restCommentReplyVO);

}