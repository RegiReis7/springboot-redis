package com.regiBoot.repository;

import com.regiBoot.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    @Override
    public boolean saveUser(Usuario usuario) {
        try {
            redisTemplate.opsForHash().put(KEY, usuario.getId().toString(), usuario);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Usuario> listarUsarios() {
        try {
            return redisTemplate.opsForHash().values(KEY);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario getUserById(Long id) {
        try {
            return (Usuario) redisTemplate.opsForHash().get(KEY, id.toString());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
