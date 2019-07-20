public interface DAO<Entity,Key> {
    public void create(Entity entity);
    public Entity read(Key key);
    public void update(Entity entity);
    public void delete(Entity entity);
}
