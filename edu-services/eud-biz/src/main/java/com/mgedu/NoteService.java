package com.mgedu;

import com.mgedu.dao.NoteRepository;
import com.mgedu.entity.Note;
import com.mgedu.api.INoteService;
import com.mgedu.dto.NoteBean;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author heyanjing
 * date:2018-12-07 2018/12/7:15:46
 */
@Service
public class NoteService implements INoteService {
    @Autowired
    NoteRepository noteRepository;
    @Override
    public NoteBean createNote(NoteBean note) {

        try {
            Note entity = new Note();
            BeanUtils.copyProperties(entity,note);
            Note save = this.noteRepository.save(entity);
            BeanUtils.copyProperties(note,save);
            return note;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NoteBean getNoteById(String noteId) {
        return null;
    }
}
