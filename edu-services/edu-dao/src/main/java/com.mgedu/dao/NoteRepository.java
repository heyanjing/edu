package com.mgedu.dao;

import com.mgedu.dao.repo.BaseRepo;
import com.mgedu.entity.Note;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends BaseRepo<Note, String> {

}
