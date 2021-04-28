<?php

namespace App\Entity;

use App\Repository\StudentRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=StudentRepository::class)
 */
class Student
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $NCS;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $email;

    public function getEmail()
    {
        return $this->email;
    }

    public function setEmail($email): void
{
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getNCS()
    {
        return $this->NCS;
    }
}
