public abstract class NotAliveObject extends newObject implements canBeMoved
{
    Status status;
    protected enum Status
    {
        BROKEN ("сломан/а"),
        NORMAL ("нормальный/ая");
        private String status;

        Status(String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }
}
