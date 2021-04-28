<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210415090749 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE testfitness ADD cours_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE testfitness ADD CONSTRAINT FK_60B2DDD97ECF78B0 FOREIGN KEY (cours_id) REFERENCES cours (id) ON DELETE CASCADE');
        $this->addSql('CREATE INDEX IDX_60B2DDD97ECF78B0 ON testfitness (cours_id)');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE testfitness DROP FOREIGN KEY FK_60B2DDD97ECF78B0');
        $this->addSql('DROP INDEX IDX_60B2DDD97ECF78B0 ON testfitness');
        $this->addSql('ALTER TABLE testfitness DROP cours_id');
    }
}
