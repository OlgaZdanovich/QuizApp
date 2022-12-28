package com.example.tmsquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tmsquizapp.R
import com.example.tmsquizapp.databinding.FragmentQuestionBinding
import com.example.tmsquizapp.viewmodels.QuizViewModel


class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = (activity as MainActivity).viewModel
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()

    }

    private fun setupViews() {
        binding.prevButton.setOnClickListener {
            viewModel.loadPreviousQuestion()
        }
    }

    private fun setupObservers() {
        viewModel.currentQuestionId.observe(viewLifecycleOwner){ questionNumber ->
            binding.prevButton.isEnabled = questionNumber != 0
            if(questionNumber == viewModel.getQuestionsAmount())
            {
                binding.nextButton.text = "Finish"
                binding.nextButton.setOnClickListener {
                    findNavController().navigate(R.id.action_questionFragment_to_quizResultFragment)
                }
            }
            else
            {
                binding.nextButton.text = "&gt;"
                binding.nextButton.setOnClickListener {
                    viewModel.saveUserAnswer()
                    viewModel.loadNextQuestion()
                }
            }
            binding.currentTextView.text = questionNumber.toString()
            setupAnswers(questionNumber)
        }
        viewModel.currentQuestion.observe(viewLifecycleOwner){ question ->
            binding.questionTextView.text = question
        }
    }

    private fun setupAnswers(questionNumber: Int) {
        val answers = viewModel.loadAnswers(questionNumber)
        binding.firstRB.text = answers[0]
        binding.secondRB .text = answers[1]
        binding.thirdRB.text = answers[2]
        binding.fourthRB.text = answers[3]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}